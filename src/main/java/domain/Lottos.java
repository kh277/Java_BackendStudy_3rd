package domain;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lottos
{
    private final List<Lotto> lottos = new ArrayList<>();
    private int buyCount = 0;

    public Lottos(int count)
    {
        this.buyCount = count;
    }

    public void addManualLottos(List<List<Integer>> manualLottos)
    {
        for (List<Integer> manualLotto : manualLottos)
            lottos.add((Lotto) manualLotto);
    }

    // 랜덤한 로또 숫자 + 보너스 번호 생성
    private List<Integer> generateLottoNumbers()
    {
        List<Integer> numbers = new ArrayList<>();
        for (int i=1; i<=LottoConstants.MAX_LOTTO_NUMBER; i++)
            numbers.add(i);

        Collections.shuffle(numbers);

        return numbers.subList(0, LottoConstants.LOTTO_COUNT+LottoConstants.BONUS_LOTTO_COUNT).stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // 로또 여러 장 생성
    public void generateLottos(int additionalCount)
    {
        for (int i=0; i<additionalCount; i++)
            lottos.add(new Lotto(generateLottoNumbers()));
    }

    // 모든 로또 티켓에 대해 일치하는 개수 세기
    public Map<Rank, Long> getTotalCorrectCount(List<Integer> lastweekGoalNumber, int lastweekBonusGoalNumber)
    {
        Map<Rank, Long> result = lottos.stream()
                .map(lotto -> {
                    int correctCount = (int) lotto.getLottoNumbers().stream()
                            .filter(lastweekGoalNumber::contains)
                            .count();
                    boolean isBonus = lotto.getLottoNumbers()
                            .contains(lastweekBonusGoalNumber);
                    return Rank.calculateMatchCount(correctCount, isBonus);
                })
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (Rank rank: Rank.values())
            result.putIfAbsent(rank, 0L);

        return result;
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