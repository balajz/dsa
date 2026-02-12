package main

type ListNode struct {
	Val int
	Next *ListNode
}

func middleNode2(head *ListNode) *ListNode {
	slow, fast := head, head

	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}
	return slow
}

func middleNode1(head *ListNode) *ListNode {
	temp := head
	length := 0

	for temp != nil {
		length++
		temp = temp.Next
	}
	middle := length / 2  + 1

	temp = head

	for temp != nil {
		middle--
		if middle == 0 {
			break
		}
		temp = temp.Next
	}
	return temp
}

