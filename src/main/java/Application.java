import domain.Lottos;
import view.InputView;
import view.ResultView;

import java.util.List;

public class Application
{
    public static void main (String[] args)
    {
        // 구입 금액 입력
        int totalBuyCount = InputView.getTotalCost();
        final Lottos tickets = new Lottos(totalBuyCount);
//

        // 수동 로또 입력 처리 및 생성
        int manualBuyCount = InputView.getManualBuyCount(totalBuyCount);
        tickets.addManualLottos(InputView.getManualLottoNumber(manualBuyCount));


        ////// 여기까지만 처리했음 -----------



        // 자동 로또 구입 및 번호 생성
        tickets.generateLottos(totalBuyCount-manualBuyCount);





        // 가지고 있는 로또 출력
        ResultView.printLottos(tickets.getLottos());

        // 지난주 로또 번호를 입력받기
        List<Integer> lastweekGoalNumber = InputView.getLastweekGoalNumber();
        int lastweekBonusGoalNumber = InputView.getLastweekBonusGoalNumber();

        // 결과 출력
        ResultView.calculateProceed(lastweekGoalNumber, lastweekBonusGoalNumber, tickets);

    }
}
