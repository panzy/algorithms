import java.util.Arrays;

/**
 * Solve the LeetCode problem "765. Couples Holding Hands" in Java, again,
 * using a graph.
 *
 * Problem description:
 * https://leetcode.com/problems/couples-holding-hands/
 *
 * by Zhiyong Pan on 8-Sep-2020
 *
 * -------- Solution status -----------------------
 * Success
 * Runtime: 1 ms, faster than 41.34% of Java online submissions for Couples Holding Hands.
 * Memory Usage: 37 MB, less than 59.52% of Java online submissions for Couples Holding Hands.
 */
class Solution2 {
    public int minSwapsCouples(int[] row) {

        // My first solution approaches the problem in a pretty intuitive way,
        // it only uses an array to accelerate finding who is seating where. But
        // since this problem is tagged "graph" on LeetCode web site and I had
        // no idea at the beginning how graph could be helpful for this problem,
        // I decided to give it a go again with a graph.
        //
        // It's really satisfying to come to a formula that calculates the
        // answer. My first solution get the answer - minimum swap times - by
        // actually doing the swaps. The solution was tested and accepted, but
        // wasn't proved. Now, after analyzing the graph, I can explain why my
        // first solution is correct: there is no swap strategy better than
        // others; it doesn't matter how you arrange your swaps; the total times
        // will be the same.
        //
        // Due to my poor implementation of counting connected components of a
        // graph, this new solution is much inefficient than the first solution.
        // I don't think a graph solution can ever defeat the first one, which
        // runs extremely fast. The value of developing this graph solution,
        // however, is to help to understand the question and to prove my first
        // solution.


        // How to represent a row of people with a graph:
        //
        // 1. Along the row, each two seats is considered a node.
        //
        // 2. The edges are directed.
        //
        // 3. Each edge represents a separated couple, with the first person
        //    (with lower id, which should be an even number) being in the start
        //    node, and the second in the end node. For example, there are two
        //    edges out of node "4+8", one goes to "5+?", the other goes to
        //    "9+?". There will be no edges out of node "5+7" because both #5
        //    and #7 are odd.

        // What are the facts of such a graph?
        //
        // 1. For each separated couple, there is one and only one directed
        //    edge.
        //
        // 2. A node's degree is either zero or two. It's obvious that if a node
        //    contains a couple then the degree is zero, but why two otherwise?
        //    Because the node involves exactly two couples.
        //
        // 3. After each effective swap, the number of total edges reduces by
        //    one or two:
        //         A) If the two nodes were isolated from the rest of the graph,
        //            such as "0+9" <=> "1+8", then after swap both nodes are
        //            clean, two edges removed.
        //         B) Otherwise, only one of the node is clean, and of the two
        //            edges it has before the swap, one is eliminated because the
        //            corresponding couple has united, the other is brought away by
        //            the person who left this node. The direction doesn't matter
        //            here. For example, before swap, node "4+8" points "5+7" and
        //            "1+9"; after swap, we get "4+5", and the edge which was from
        //            "4+8" to "1+9" is now from "7+8" to "1+9". The rest of the
        //            graph remains.
        //
        // 4. For each connected component of the graph, all the swaps except the
        //    last one each eliminates a single edge, so (totalEdges -
        //    numberOfConnectedComponents) is times of swap needed.

        // So, the approach for this problem?
        //
        // 1. build the graph;
        // 2. count the edges;
        // 3. count the connected components;
        // 4. do a subtraction with the two number;


        final int MAX_EDGES = row.length / 2;
        // the worst scenario is all couples are separated.

        // each edge is represented by two number: the start seat pair, and the
        // end seat pair.
        int[][] edges = new int[MAX_EDGES][];

        int[] seats = Solution.initPeopleArray(row);

        int edgeCnt = 0;

        // for each two seats along the row, generate edges for it.
        for (int i = 0; i < row.length; i += 2) {
            if (!Solution.isCouple(row[i], row[i + 1])) {
                int thisNodeIdx = i / 2;

                // for each people in this node, an edge is needed if that
                // person's id is even.
                for (int j = i; j < i + 2; ++j) {
                    if (row[j] % 2 == 0) {
                        int whichSeatIsMyLoverSittingAt = seats[Solution.theOther(row[j])];
                        int thatNodeIdx = whichSeatIsMyLoverSittingAt / 2;
                        edges[edgeCnt++] = new int[] { thisNodeIdx, thatNodeIdx };
                    }
                }
            }
        }

        // heavy work is done in numberOfConnectedComponents().
        return edgeCnt - numberOfConnectedComponents(edges, row.length);
    }

    /**
     * Not a real color. Just a number to flag a connected component of a graph.
     *
     * All nodes that are connected to each other have the same "color".
     */
    static class Color {
        public int color;
        public Color(int c) { color = c; }
    }

    /**
     * Given a graph represented by its edges, determine how many connected
     * components are there.
     *
     * @param edges each edge is an array being [ startNodeIndex, endNodeIndex ].
     * @param nodeNum how many nodes?
     * @return number of connected components.
     */
    static int numberOfConnectedComponents(int[][] edges, int nodeNum) {
        Color[] nodeColors = new Color[nodeNum];

        int nextColorValue = 0;

        // Repeatedly walk through all edges, lowering a node's color if it's
        // higher than the opposite node's.
        // Stop while no further lowering is possible.
        while (true) {
            boolean colorValueLowered = false;

            for (int i = 0; i < edges.length && edges[i] != null; ++i) {
                int startNode = edges[i][0];
                int endNode = edges[i][1];

                if (nodeColors[startNode] == null) {
                    if (nodeColors[endNode] == null) {
                        nodeColors[startNode] = nodeColors[endNode] = new Color(nextColorValue++);
                    } else {
                        nodeColors[startNode] = nodeColors[endNode];
                    }
                } else {
                    if (nodeColors[endNode] == null) {
                        nodeColors[endNode] = nodeColors[startNode];
                    } else {
                        if (nodeColors[startNode].color < nodeColors[endNode].color) {
                            nodeColors[endNode] = nodeColors[startNode];
                            colorValueLowered = true;
                        } else if (nodeColors[startNode].color > nodeColors[endNode].color) {
                            nodeColors[startNode] = nodeColors[endNode];
                            colorValueLowered = true;
                        }
                    }
                }
            }

            if (!colorValueLowered)
                break;
        }

        // count how many colors are used
        int colorNum = 0;
        boolean[] usedColors = new boolean[nodeNum]; // use it like a set
        Arrays.fill(usedColors, false);
        for (int i = 0; i < nodeNum; ++i) {
            if (nodeColors[i] != null && !usedColors[nodeColors[i].color]) {
                usedColors[nodeColors[i].color] = true;
                ++colorNum;
            }
        }

        return colorNum;
    }
}
