# Paper
**1.问题陈述**

"Letter(信封)"、"Legal(adj. 法律允许的，合法的；与法律有关的，法律的；（与衡平法相对）普通法或成文法确认的；神学律法的，
与神学律法有关的；<美>（纸张）标准大小的)"、"Tabloid(n. 小报，通俗小报，八卦小报)"是纸张尺寸的例子。Letter和Legal都有8英寸半宽，
Legal有14英寸长，Letter有11英寸长。这意味着14封Legal和11张Legal有相同的总长(154)，
当然，除非我们说的"信件"指的是"政府信件"或者不是"法律信件"而是"初级法律信件"。在手工造纸的时代，11英寸的长度是相当实用的，因为据报道，
这大约是一个有经验的捞纸工手臂的平均最大伸展长度的四分之一。幸运的是，这个问题是关于一个更加系统的剪纸的方式：A系列。

A系列的纸张被编号为A0,A1,A2,并且直到无穷。A0是这些纸张中最大的。A0纸张的面积正好是1平方米。

A系列的所有纸张尺寸都具有相同的纵横比。更准确地说，A系列中任何一张纸的长边和短边之比都等于根号2。

对于每个i, A(i+1)纸的长边等于A(i)纸的短边。

根据前面的两个定义，A系列有以下有用的性质:无论何时，你拿一张A(i)纸，把它切成两半(使用一种通过纸张长边中心的切口的切法)，你会得到两张A(i+1)纸。
也就是说，A1是A0的1 / 2,A2是A1的1 / 2，以此类推。

你被给一个A，A[i]代表你库存中A(i)大小的纸张的数量，例如，A[4]是你目前拥有的A4纸的数量。

你不允许以任何方式剪纸。你只能用胶带把纸张连接起来(无缝且没有任何浪费)。你用这种方法连接的论文不能重叠。你能拿一些纸，拼出一张尺寸为A0的纸吗?
如果可以，返回“可能”，否则返回“不可能”。

**定义**
类：A0Paper

方法：canBuild

参数：int[]

返回值：String

方法签名：String canBuild(int[] A)
(确保方法是公开的)

时间限制：2s

内存限制：256MB


**Notes**
- 返回值区分大小写。确保返回的字符串与问题语句中显示的完全相同。

**约束**
- A包含1到21个元素
- A的每个元素将在0到220之间

**例子**
1.
{0,3}
Returns: "Possible"
我们有0张A0纸和3张A1纸。我们能够联合三张A1纸中的两张去获得一张A0.

2.
{0,1,2}
Returns: "Possible"
这一次，我们可以把两篇A2的论文结合起来，得到又一个A1。然后，两个A1(原始的一个A1和我们从两个A2得到的一个A1)可以结合起来得到A0。
3.
{0, 0, 0, 0, 15}
Returns: "Impossible"
一张A0的纸可以由16张A4纸组装而成，但这里只有15张。
4.
{2, 0, 0, 0, 0, 0, 0, 3 2 0 0 5 0 3 0, 0, 1, 0, 0, 0, 5}
Returns: "Possible"
我们已经有两张A0的纸了，所以我们只需要其中一张就可以了。

此问题陈述为TopCoder, Inc.的专有的和私有的财产。未经TopCoder, Inc.事先书面同意，任何未经授权的使用或复制此信息都是严格禁止的。(c) 2003年,TopCoder公司。保留所有权利。

# AB
该字符串正好有N个字符，每个字符都是“A”或“B”。
字符串s恰好有K对 ( i , j ) (0 <= i < j <= N -1)，使得s [ i ] = 'A' 和s [ j ] = 'B'。

Definition

Class:	AB
Method:	createString
Parameters:	int, int
Returns:	String
Method signature:	String createString(int N, int K)
(be sure your method is public)


Constraints
-	N will be between 2 and 50, inclusive.
-	K will be between 0 and N(N-1)/2, inclusive.

Examples
0)

3
2
Returns: "ABB"
This string has exactly two pairs (i, j) mentioned in the statement: (0, 1) and (0, 2).
1)

2
0
Returns: "BA"
Please note that there are valid test cases with K = 0.
2)

5
8
Returns: ""
Five characters is too short for this value of K.
3)

10
12
Returns: "BAABBABAAB"
Please note that this is an example of a solution; other valid solutions will also be accepted.

# Caketown
你和一些朋友要去风景优美的蛋糕镇的一家蛋糕店。桌子上有各种不同大小的蛋糕，大小是以“咬一口”来衡量的。你已经决定轮流挑选蛋糕，直到所有的蛋糕都被你或你的朋友选中。
你们都喜欢大蛋糕，所以轮到每个人挑剩下最大的蛋糕。如果最大的蛋糕有一个领带，那么挑哪个领带的蛋糕并不重要。因为今天是你的生日，你可以挑第一个蛋糕。
例如，假设你有两个朋友，有5块蛋糕，大小分别为6,7,9,6,4。你会选择9口蛋糕，你的第一个朋友会选择7口蛋糕，你的另一个朋友会得到6口蛋糕中的一个，
你会得到另外6口蛋糕，而你的第一个朋友会得到4口蛋糕。你一共可以吃15口蛋糕。
numFriends将是您拥有的朋友数量(不包括您自己)。cakeesize将是一个整数列表，每个整数的大小相当于一个蛋糕的大小——不一定是按照大小的顺序。返回你将得到的蛋糕的总咬。

**Definition**

Class:Caketown

Method:
howManyBites

Parameters:
int[], int

Returns:
int

Method signature:
int howManyBites(int[] cakeSize, int numFriends)

(be sure your method is public)
Limits

Time limit (s):
2.000

Memory limit (MB):
64

时间限制:

2.000

内存限制(MB):

64

**约束**

- cakeSize将包含1到10个元素。

- cakeesize的每个元素都在1到10之间。

- numFriends将在1到5之间，包括5。

**例子**

0)

{10}

5

返回:10

人可能比蛋糕多，但幸运的是你先挑。

1）

{1 1 1 5 1}

3.

返回:6

你会选择5号的蛋糕，最后你也会得到1号的蛋糕。

2）

{6、7、9、6、4}

2

返回:15

问题陈述中的例子。
> 以上均用于个人学习。