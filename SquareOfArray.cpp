#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

std::vector<int> sortedSquares1(std::vector<int>& arr) {
    for (int i = 0; i < arr.size(); i++) {
        arr[i] = arr[i] * arr[i];
    }
    std::sort(arr.begin(), arr.end());
    return arr;
}

std::vector<int> sortedSquares(std::vector<int>& nums) {
    int pt1 = 0;
    int pt2 = nums.size() - 1;
    int n = nums.size() - 1;

    std::vector<int> result(n + 1);

    while (pt1 <= pt2) {
        int a = pow(nums[pt1], 2);
        int b = pow(nums[pt2], 2);
        if (a > b) {
            result[n] = a;
            pt1++;
        }
        else {
            result[n] = b;
            pt2--;
        }
        n--;
    }
    return result;
}

void print(std::vector<int>& arr) {
    std::cout << "----------------------------------" << std::endl;
    for (int i = 0; i < arr.size(); i++) {
        std::cout << arr[i] << "   ";
    }
    std::cout << std::endl << "----------------------------------" << std::endl;
}

int main() {
    std::cout << "       Sorted Array     " << std::endl;
    std::vector<int> nums = {-4, -1, 0, 3, 10};
    std::vector<int> result = sortedSquares(nums);
    print(result);
    return 0;
}
