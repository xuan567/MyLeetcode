package 数组和字符串;

import java.util.*;

public class leetcode49字母异位词分组 {
    /*
    49. 字母异位词分组
    给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

    示例:
    输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
    输出:
    [
      ["ate","eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]
    * */

    //创建一个哈希表
    //遍历整个字符串数组，将每次遍历的字符串转化成字符数组，然后将其排序，将其作为哈希表的键
    //然后取出该键对应的值List<String> list = map.getOrDefault(key,new ArrayList<>())
    //将遍历到的字符串加到list里面
    //然后再更新map
    //最后返回ArrayList<>(map.values())

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] arrs = str.toCharArray();
            Arrays.sort(arrs);
            String key = new String(arrs);
            List<String> list = map.getOrDefault(key,new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }
}
