import domain.Lotto;
import view.InputView;

import java.util.List;

public class Application
{
    public static void main (String[] args)
    {
        final int lottoCount = InputView.getLottoCount();

        for (List<Integer> curNum : Lotto.generateLottos(lottoCount))
        {
            System.out.println(curNum);
        }
    }
}
