package view;

import domain.Lotto;
import domain.Lottos;
import domain.Rank;

import java.util.List;
import java.util.Map;


public class ResultView
{
    public static void printLottos(List<Lotto> lottos)
    {
        for (Lotto lotto : lottos)
            System.out.println(lotto.getLottoNumbers());
    }

    public static void calculateProceed(List<Integer> lastweekGoalNumber, int lastweekBonusGoalNumber, Lottos tickets)
    {
        Map<Rank, Long> lottosResult = tickets.getTotalCorrectCount(lastweekGoalNumber, lastweekBonusGoalNumber);

        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + lottosResult.get(Rank.FIFTH));
        System.out.println("4개 일치 (50000원)- " + lottosResult.get(Rank.FOURTH));
        System.out.println("5개 일치 (1500000원)- " + lottosResult.get(Rank.THIRD));
        System.out.println("5개 일치, 보너스 볼 일치 (30000000원)- " + lottosResult.get(Rank.SECOND));
        System.out.println("6개 일치 (2000000000원)- " + lottosResult.get(Rank.FIRST));

        double totalProceed = (lottosResult.get(Rank.FIFTH)*Rank.FIFTH.getPrize()
            + lottosResult.get(Rank.FOURTH)*Rank.FOURTH.getPrize()
            + lottosResult.get(Rank.THIRD)*Rank.THIRD.getPrize()
            + lottosResult.get(Rank.SECOND)*Rank.SECOND.getPrize()
            + lottosResult.get(Rank.FIRST)*Rank.FIRST.getPrize()) / (double)tickets.getCost();

        System.out.println("총 수익률은 " + String.format("%.2f", totalProceed) + "입니다.");
    }

}