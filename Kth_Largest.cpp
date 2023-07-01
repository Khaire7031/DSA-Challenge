#include<iostream>
#include <vector>
#include<queue>
#include <algorithm>
using namespace std;

// Approach 1
// time Complexity O(n+k*(log(k)))
// Space  Complexity O(k)

int findKthLargest(vector<int>& nums, int k) {
    // using priority queue
    // priority_queue<int> p;
    priority_queue<int, vector<int>, greater<int>> p;
    for(auto i : nums){
        if(p.size()<k){
            p.push(i);
        }else if(p.top() < i){
            p.pop();
            p.push(i);
        }
    }
    return p.top();  
}

// 2nd Approach
// using Sorting 
// time Cmplexity O(n*Log(n))
// Space Complexity O(1)
int findKthLargest1(vector<int>& nums, int k) {
    // sort(nums.begin(),nums.end());
    // return nums[nums.size()-k];
    sort(nums.begin(), nums.end());
    return nums[nums.size() - k];
}

int main(){
    cout<<"        Kth Largest Number"<<endl;
    vector<int> nums = {3, 2, 1, 5, 6, 4};
    int k = 2;
    cout << findKthLargest(nums, k) << endl;
    cout << findKthLargest1(nums, k) << endl;
    return 0;
}

//-----------------------------------------------------------------------

// #include<iostream>
// #include <vector>
// #include<queue>
// #include <algorithm>
// using namespace std;

// // Approach 1
// // time Complexity O(n+k*(log(k)))
// // Space  Complexity O(k)

// int findKthLargest(vector<int>& nums, int k) {
//     // using priority queue
//     // priority_queue<int> p;
//     priority_queue<int, vector<int>, greater<int>> p;
//     for(auto i : nums){
//         if(p.size()<k){
//             p.push(i);
//         }else if(p.top() < i){
//             p.pop();
//             p.push(i);
//         }
//     }
//     return p.top();  
// }

// // 2nd Approach
// // using Sorting 
// // time Cmplexity O(n*Log(n))
// // Space Complexity O(1)
// int findKthLargest1(vector<int>& nums, int k) {
//     sort(nums.begin(),nums.end());
//     return nums[nums.size()-k];
// }

// int main(){
//     cout<<"        Kth Largest Number"<<endl;
//     vector<int> nums = {3, 2, 1, 5, 6, 4};
//     int k = 2;
//     cout << findKthLargest(nums, k) << endl;
//     // cout << findKthLargest1(nums, k) << endl;
//     return 0;
// }
