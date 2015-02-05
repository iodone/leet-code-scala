
class Solution:
    # @return a tuple, (index1, index2)
    def lengthOfLongestSubstring(self, s):
        s = list(s) 
        max_len = 0
        cur_len = 0
        cur_list = [] 
        for i in range(len(s)):
            cur_list.append(s[i])
            same_index = next((j for j in range(len(cur_list) - 1) if cur_list[j] == s[i]), -1)
            del cur_list[0:(same_index + 1)] 
            cur_len = len(cur_list) 
            if cur_len > max_len:
                max_len = cur_len
        return max_len        

def main():
    test_list = 'ddddd' 
    s = Solution();
    ret = s.lengthOfLongestSubstring(test_list)
    print ret

if __name__ == "__main__":
    main()
