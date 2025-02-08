<h2> 282 372
2456. Most Popular Video Creator</h2><hr><div><p>You are given two string arrays <code>creators</code> and <code>ids</code>, and an integer array <code>views</code>, all of length <code>n</code>. The <code>i<sup>th</sup></code> video on a platform was created by <code>creators[i]</code>, has an id of <code>ids[i]</code>, and has <code>views[i]</code> views.</p>

<p>The <strong>popularity</strong> of a creator is the <strong>sum</strong> of the number of views on <strong>all</strong> of the creator's videos. Find the creator with the <strong>highest</strong> popularity and the id of their <strong>most</strong> viewed video.</p>

<ul>
	<li>If multiple creators have the highest popularity, find all of them.</li>
	<li>If multiple videos have the highest view count for a creator, find the lexicographically <strong>smallest</strong> id.</li>
</ul>

<p>Note: It is possible for different videos to have the same <code>id</code>, meaning that <code>id</code>s do not uniquely identify a video. For example, two videos with the same ID are considered as distinct videos with their own viewcount.</p>

<p>Return<em> </em>a <strong>2D array</strong> of <strong>strings</strong> <code>answer</code> where <code>answer[i] = [creators<sub>i</sub>, id<sub>i</sub>]</code> means that <code>creators<sub>i</sub></code> has the <strong>highest</strong> popularity and <code>id<sub>i</sub></code> is the <strong>id</strong> of their most <strong>popular</strong> video. The answer can be returned in any order.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">creators = ["alice","bob","alice","chris"], ids = ["one","two","three","four"], views = [5,10,5,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">[["alice","one"],["bob","two"]]</span></p>

<p><strong>Explanation:</strong></p>

<p>The popularity of alice is 5 + 5 = 10.<br>
The popularity of bob is 10.<br>
The popularity of chris is 4.<br>
alice and bob are the most popular creators.<br>
For bob, the video with the highest view count is "two".<br>
For alice, the videos with the highest view count are "one" and "three". Since "one" is lexicographically smaller than "three", it is included in the answer.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">creators = ["alice","alice","alice"], ids = ["a","b","c"], views = [1,2,2]</span></p>

<p><strong>Output:</strong> <span class="example-io">[["alice","b"]]</span></p>

<p><strong>Explanation:</strong></p>

<p>The videos with id "b" and "c" have the highest view count.<br>
Since "b" is lexicographically smaller than "c", it is included in the answer.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == creators.length == ids.length == views.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= creators[i].length, ids[i].length &lt;= 5</code></li>
	<li><code>creators[i]</code> and <code>ids[i]</code> consist only of lowercase English letters.</li>
	<li><code>0 &lt;= views[i] &lt;= 10<sup>5</sup></code></li>
</ul>
</div>