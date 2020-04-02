package PalindromeNumber

/**
	* 解题报告
	* 说明： 逆序比较相等就是回文数
	*/

object Solution {

		def reverse(x: Int) = {
			var p = x
			var r = 0
			while(p != 0) {
				r = r * 10 + p % 10 
				p = p / 10
			}
			r
		}

    def isPalindrome(x: Int): Boolean = {
			if (x < 0) false
			else x == reverse(x)
    }
}