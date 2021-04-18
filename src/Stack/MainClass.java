package Stack;

import java.util.Stack;

public class MainClass {
    public static void main(String[] args){
//        InfixToPostFix postFix = new InfixToPostFix();
//        String ans = postFix.Solution("a+b*(c^d-e)^(f+g*h)-i");
//        System.out.println(ans);

//        PostfixToInfix infix = new PostfixToInfix();
//        System.out.println(infix.Solution("ab*c+"));

//        CheckForBalancedBrackets check = new CheckForBalancedBrackets();
//        System.out.println(check.Solution("[()]{}{[()()]()}"));

//        NextGreaterElement nextGreaterElement = new NextGreaterElement();
//        int[] arr = {11, 13, 21, 3};
//        nextGreaterElement.Solution(arr);

//        NextGreaterFrequencyElement nextGreaterFrequencyElement = new NextGreaterFrequencyElement();
//        int a[] = { 1, 1, 2, 3, 4, 2, 1 };
//        int[] ans = nextGreaterFrequencyElement.Solution2(a);
//        System.out.println(ans);

//        NumberOfNGEToRight numberOfNGEToRight = new NumberOfNGEToRight();
//        int a[] = { 3, 4, 2, 7, 5, 8, 10, 6 };
//        System.out.println(numberOfNGEToRight.Solution(a, 0));

//        Maximum_product_of_indexes_of_next_greater_on_left_and_Right maxProduct = new Maximum_product_of_indexes_of_next_greater_on_left_and_Right();
//        int[] arr = {1, 1, 1, 1, 0, 1, 1, 1, 1, 1};
//        System.out.println(maxProduct.Solution(arr));

        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
//        ReverseAStackUsingRecursion reverse = new ReverseAStackUsingRecursion();
//        reverse.Solution(st);
//        System.out.println(st);

//        SortAStackUsingRecursion sortStack = new SortAStackUsingRecursion();
//        sortStack.Solution(st);
//        System.out.println(st);

//        SortAStackUsingATemporaryStack sortAStackUsingATemporaryStack = new SortAStackUsingATemporaryStack();
//        st = sortAStackUsingATemporaryStack.Solution(st);
//        System.out.println(st);

//        Delete_array_elements_which_are_smaller_than_next_or_become_smaller delete = new Delete_array_elements_which_are_smaller_than_next_or_become_smaller();
//        int[] arr = {20, 10, 25, 30, 40};
//        arr = delete.Solution(arr, 2);
//        System.out.println(arr);

//        MaximumDepthOfNestedParenthesis maxDepth = new MaximumDepthOfNestedParenthesis();
//        int ans = maxDepth.Solution2("(b) ((c) ()");
//        System.out.println(ans);

//        StockSpanProblem stockSpanProblem = new StockSpanProblem();
//        int[] a = {100, 80, 60, 70, 60, 75, 85};
//        int[] res = stockSpanProblem.Solution(a);
//        System.out.println(res);

        int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
        MaximumAreaHistogram maxAreaHist = new MaximumAreaHistogram();
        int maxArea = maxAreaHist.Solution(hist);
        System.out.println(maxArea);
    }
}