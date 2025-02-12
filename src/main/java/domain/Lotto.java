package domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Lotto
{
    // 랜덤한 로또 숫자 6개 생성
    private static List<Integer> generateLottoNumbers()
    {
        List<Integer> numbers = new ArrayList<>();
        for (int i=1; i<46; i++)
            numbers.add(i);

        Collections.shuffle(numbers);

        return numbers.subList(0, 6).stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // 로또 여러 장 생성
    public static List<List<Integer>> generateLottos(int count)
    {
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<count; i++)
            result.add(generateLottoNumbers());

        return result;
    }
}