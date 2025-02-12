package domain;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Lottos
{
    private final List<Lotto> lottos = new ArrayList<>();
    private int buyCount = 0;

    public Lottos(int count)
    {
        this.buyCount = count;
    }

    // 랜덤한 로또 숫자 6개 생성
    private List<Integer> generateLottoNumbers()
    {
        List<Integer> numbers = new ArrayList<>();
        for (int i=1; i<=LottoConstants.MAX_LOTTO_NUMBER; i++)
            numbers.add(i);

        Collections.shuffle(numbers);

        return numbers.subList(0, LottoConstants.LOTTO_COUNT).stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // 로또 여러 장 생성
    public void generateLottos()
    {
        for (int i=0; i<buyCount; i++)
            lottos.add(new Lotto(generateLottoNumbers()));
    }

    // 모든 로또 티켓에 대해 일치하는 개수 세기
    public List<Integer> getTotalCorrectCount(List<Integer> lastweekGoalNumber)
    {
        List<Integer> correctCount = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0));
        Lotto lastweekLotto = new Lotto(lastweekGoalNumber);

        for (int i=0; i<buyCount; i++)
        {
            int temp = lastweekLotto.getCorrectCount(lottos.get(i));
            correctCount.set(temp, correctCount.get(temp) + 1);
        }

        return correctCount.subList(3, LottoConstants.LOTTO_COUNT+1);
    }

    public List<Lotto> getLottos()
    {
        return lottos;
    }

    public int getCost()
    {
        return buyCount*1000;
    }
}