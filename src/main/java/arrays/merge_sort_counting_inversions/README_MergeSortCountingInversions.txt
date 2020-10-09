https://www.hackerrank.com/challenges/ctci-merge-sort/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
In an array,arr, the elements at indices i and j (where i < j) form an
inversion if arr[i] > arr[j]. In other words, inverted elements arr[i]
and arr[j] are considered to be "out of order". To correct an inversion,
we can swap adjacent elements.

For example, consider the dataset arr={2,4,1}. It has two inversions:
(4,1) and (2,1). To sort the array, we must perform the following two
swaps to correct the inversions:

Given d datasets, print the number of inversions that must be swapped
to sort each dataset on a new line.

Function Description

Complete the function countInversions in the editor below. It must return
an integer representing the number of inversions required to sort the array.

countInversions has the following parameter(s):

arr: an array of integers to sort .
Input Format

The first line contains an integer, d, the number of datasets.

Each of the next d pairs of lines is as follows:

The first line contains an integer, n, the number of elements in arr.
The second line contains n space-separated integers, arr[i].

Output Format

For each of the d datasets, return the number of inversions that must be swapped to sort the dataset.

Sample Input

2
5
1 1 1 2 2
5
2 1 3 1 2
Sample Output

0
4
