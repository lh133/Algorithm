package com.lh.LeetCode.July.July6;

import java.util.*;

/**
 * 1418. 点菜展示表
 * <p>
 * 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
 * <p>
 * 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
 * <p>
 * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
 * <p>
 * 提示：
 * <p>
 * 1 <= orders.length <= 5 * 10^4
 * orders[i].length == 3
 * 1 <= customerNamei.length, foodItemi.length <= 20
 * customerNamei 和 foodItemi 由大小写英文字母及空格字符 ' ' 组成。
 * tableNumberi 是 1 到 500 范围内的整数。
 *
 * @Author: LH
 * @Date: 2021/7/6 9:18
 */
public class displayTable {
}

class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        // 保存菜品名称，去重
        Set<String> nameSet = new HashSet<>();
        // 保存桌号和对应菜品点餐数量
        Map<Integer, Map<String, Integer>> foodsMap = new HashMap<>();
        for (List<String> order : orders) {
            nameSet.add(order.get(2));
            int tableNOs = Integer.parseInt(order.get(1));
            Map<String, Integer> map = foodsMap.getOrDefault(tableNOs, new HashMap<>());
            map.put(order.get(2), map.getOrDefault(order.get(2), 0) + 1);
            foodsMap.put(tableNOs, map);
        }

        // 菜品数量，并排序
        int n = nameSet.size();
        List<String> foodNames = new ArrayList<>(nameSet);
        Collections.sort(foodNames);

        // 提取桌号，并按桌号升序排列
        int m = foodsMap.size();
        ArrayList<Integer> tables = new ArrayList<>(foodsMap.keySet());
        Collections.sort(tables);

        // 填写点菜表
        List<List<String>> ans = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(foodNames);
        ans.add(header);
        for (int i = 0; i < m; i++) {
            int tableNO = tables.get(i);
            Map<String, Integer> count = foodsMap.get(tableNO);
            List<String> rows = new ArrayList<>();
            rows.add(Integer.toString(tableNO));
            for (int j = 0; j < n; j++) {
                rows.add(Integer.toString(count.getOrDefault(foodNames.get(j), 0)));
            }
            ans.add(rows);
        }
        return ans;
    }
}