class Solution:
    def search(nums: [int], target: int):
        list_len = len(nums)
        not_in = -1
        l_pointer, r_pointer = 0, (list_len-1)
        
        while l_pointer <= r_pointer:
            m_index = l_pointer + (r_pointer - l_pointer)//2
            if target == nums[m_index]:
                return m_index
            elif target > nums[m_index]:
                l_pointer = m_index + 1
            else:
                r_pointer = m_index - 1
        return not_in

nums = [-1,0,3,5,9,12]
target = 9
target2 = 2
print(Solution.search(nums, target))
print(Solution.search(nums, target2))