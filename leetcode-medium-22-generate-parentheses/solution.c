/* Solve the LeetCode problem: 22. Generate Parentheses 
 *
 * Problem description:
 * https://leetcode.com/problems/generate-parentheses
 *
 * by Zhiyong Pan on 09/06/2016
 */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <math.h>

int countOpen(char *s) {
	int open = 0;
	for (char *p = s; *p; ++p) {
		if (*p == '(')
			++open;
		else if (*p == ')')
			--open;
	}
	return open;
}

/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
char** generateParenthesis(int n, int* returnSize) {
	// buffer len of a solution
	const int cols = n * 2 + 1;

	// estimate total solutions count
	int maxcnt = 1;
	for (int i = 2; i <= n; ++i)
		maxcnt *= i;

	char *lines = malloc(cols * maxcnt);
	int cnt = 1;

	// first parenthesis
	snprintf(lines, cols, "("); 

	// the rest
	for (int i = 1; i < n; ++i) {

		// for each in-progress solutions
		for (int j = 0, bc = cnt; j < bc; ++j) {
			char *line = lines + j * cols;
			int open = countOpen(line);

			// for each opened parenthesis, we can choose to close any of them now,
			for (int close = 1; close <= open; ++close) {
				char *newline = lines + cnt * cols;
				sprintf(newline, line);
				char *p = newline + strlen(newline);
				for (int l = 0; l < close; ++l) {
					p[l] = ')';
				}
				p[close] = '(';
				p[close + 1] = '\0';
				++cnt;
			}

			// or close nothing
			char *p = line + strlen(line);
			p[0] = '(';
			p[1] = '\0';
		}
	}

	// close all solutions, output
	*returnSize = cnt;
	char **results = malloc(cnt * sizeof(char*));
	for (int i = 0; i < cnt; ++i) {
		char *line = results[i] = lines + i * cols;
		int open = countOpen(line);
		char *p = line + strlen(line);
		for (int k = 0; k < open; ++k) {
			p[k] = ')';
		}
		p[open] = '\0';
	}
	return results;
}

