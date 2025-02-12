import domain.Lottos;
import view.InputView;
import view.ResultView;

import java.util.List;

public class Application
{
    public static void main (String[] args)
    {
        // 살 로또 개수 입력
        int buyCount = InputView.getLottoCount();

        // buyCount만큼 로또 번호 생성
        final Lottos tickets = new Lottos(buyCount);
        tickets.generateLottos();

        // 가지고 있는 로또 출력
        ResultView.printLottos(tickets.getLottos());

        // 지난주 로또 번호를 입력받아 당첨 통계내기
        List<Integer> lastWeekGoalNumber = InputView.getLastweekGoalNumber();
        ResultView.calculateProceed(lastWeekGoalNumber, tickets);
    }
}
