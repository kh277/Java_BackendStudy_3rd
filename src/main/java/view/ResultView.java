package view;

import domain.Lotto;
import domain.Lottos;

import java.util.List;


public class ResultView
{
    public static void printLottos(List<Lotto> lottos)
    {
        for (Lotto lotto : lottos)
            System.out.println(lotto.getLotto());
    }

    public static void calculateProceed(List<Integer> lastWeekGoalNumber, Lottos tickets)
    {
        List<Integer> correctCount = tickets.getTotalCorrectCount(lastWeekGoalNumber);

        System.out.println("당첨 통계\n---------");
        System.out.println("3개 일치 (5000원)- " + correctCount.get(0));
        System.out.println("4개 일치 (50000원)- " + correctCount.get(1));
        System.out.println("5개 일치 (1500000원)- " + correctCount.get(2));
        System.out.println("6개 일치 (2000000000원)- " + correctCount.get(3));

        double totalProceed = (correctCount.get(0)*5000 + correctCount.get(1)*50000 + correctCount.get(2)*1500000 + correctCount.get(3)*2000000000L) / (double)tickets.getCost();
        System.out.println("총 수익률은 " + String.format("%.2f", totalProceed));
    }

}