package com.train.normalize;

import java.util.ArrayList;
import java.util.List;

/**
 * @Time: 19-10-15上午11:40
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class NormalizeNumber {
    /**
     * 计算一组数据的标准化值
     * @param Scores
     * @return
     */
    public Object[] calculateStandardNumber(List<Integer> Scores){
        ArrayList <Double> scoreStandardLists = new ArrayList();
        // 获取均值
        double scoreMean = calculateNumberMean(Scores);
        // 获取std
        double scoreSTD = calculateNumberSTD(Scores, scoreMean);
        for(int score: Scores){
            double standScore = (score-scoreMean)/scoreSTD;
            scoreStandardLists.add(standScore);
        }
        Object[] consolidateValues = new Object[3];
        consolidateValues[0] = scoreMean;
        consolidateValues[1] = scoreSTD;
        consolidateValues[2] = scoreStandardLists;

        return consolidateValues;
    }

    /**
     * 获取平均分
     * @param scores
     * @return allScores
     */
    private static double calculateNumberMean(List<Integer> scores) {
        double allScores = 0.0;
        for(int score: scores){
            allScores += score;
        }
        return allScores/scores.size();
    }

    /**
     * 计算标准分
     * @param scores
     * @param scoreMean
     * @return
     */
    private static double calculateNumberSTD(List<Integer> scores, double scoreMean){
        double allSuqare = 0.0;
        for (int score: scores){
            allSuqare += (score - scoreMean)*(score - scoreMean);
        }
        double n = scores.size()*scores.size();
        return Math.sqrt(allSuqare/n);
    }

    public static void main(String[] args) {
        List<Integer> Scores = new ArrayList<Integer>(){
            {add(1);
            add(2);
            add(3);
            add(4);
            }
        };

        System.out.println(Scores);
        NormalizeNumber normalizeNumber = new NormalizeNumber();
        Object[] a = normalizeNumber.calculateStandardNumber(Scores);
        System.out.println(a[2]);

    }
}
