package domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto
{
    private final List<Integer> lottoNumber;

    public Lotto(List<Integer> numbers)
    {
        if (numbers.size() != LottoConstants.LOTTO_COUNT)
            throw new IllegalArgumentException(String.format("로또 번호는 %d개여야 합니다.", LottoConstants.LOTTO_COUNT));

        if (checkDuplicate(numbers))
            throw new IllegalArgumentException("로또 번호에 중복이 없어야 합니다.");

        this.lottoNumber = numbers;
    }

    // 중복 숫자 체크
    private boolean checkDuplicate(List<Integer> numList)
    {
        Set<Integer> numSet = new HashSet<>(numList);
        return numSet.size() != numList.size();
    }

    // 현재 로또와 다른 로또의 공통 숫자 개수 반환
    public int getCorrectCount(Lotto otherLotto)
    {
        return (int) lottoNumber.stream()
                .filter(otherLotto.getLotto()::contains)
                .count();
    }

    // 저장된 로또 숫자 반환
    public List<Integer> getLotto()
    {
        return lottoNumber;
    }
}