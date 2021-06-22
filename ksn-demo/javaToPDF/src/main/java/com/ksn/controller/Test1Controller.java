package com.ksn.controller;

import com.ksn.domain.CutData;
import com.ksn.utils.TestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/6/20 20:03
 * @description: 计算钢管切割最少方案
 */
@CrossOrigin
@Controller
@RequestMapping("/cut/plan")
public class Test1Controller {

    @PostMapping("/calculation")
    @ResponseBody
    public List<CutData> cutPlan(@RequestBody CutData data) {
        int [] lenArrTemp = new int[data.getCutPlans().size()];
        int [] aArrTemp = new int[data.getCutPlans().size()];
        if (data != null && data.getCutPlans().size() > 0) {
            for (int i = 0; i < data.getCutPlans().size(); i++) {
                lenArrTemp[i] = data.getCutPlans().get(i).getCutLength();
                aArrTemp[i] = data.getCutPlans().get(i).getCutNum();
            }
        }
//         倒序
        int[] lenArr = Arrays.stream(lenArrTemp).boxed().sorted((o1, o2) -> o2 - o1).mapToInt(p -> p).toArray();
        int[] aArr = Arrays.stream(aArrTemp).boxed().sorted((o1, o2) -> o2 - o1).mapToInt(p -> p).toArray();

        List<CutData> calculate = TestUtil.calculate(data.getTotalLength(), lenArr, aArr);
        return calculate;
    }

    @GetMapping("test")
    @ResponseBody
    public String test() {
        return "success!";
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 7, 1, 9};
//        冒泡
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int i1 = 0; i1 < arr.length - i - 1; i1++) {
//                if (arr[i1] > arr[i1 + 1]) {
//                    int temp = arr[i1];
//                    arr[i1] = arr[i1+1];
//                    arr[i1+1] = temp;
//                }
//            }
//        }
//        插入排序
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j > 0) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    j--;
                } else {
                    break;
                }
            }
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
