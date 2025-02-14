package view;

import domain.LottoConstants;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView
{
    private static final Scanner sc = new Scanner(System.in);

    // 구입할 로또의 금액 입력처리
    public static int getLottoCount()
    {
        System.out.println("구입금액을 입력해 주세요.");
        int buyCount = Integer.parseInt(sc.nextLine());

        if (buyCount < 0)
            throw new IllegalArgumentException("구입금액은 양수여야 합니다.");

        System.out.println("\n" + buyCount/LottoConstants.LOTTO_PRICE + "개를 구매했습니다.");
        return buyCount/LottoConstants.LOTTO_PRICE;
    }

    // 지난주 당첨 번호를 입력처리 및 List<Integer>로 반환
    public static List<Integer> getLastweekGoalNumber()
    {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String lastString = sc.nextLine();

         List<Integer> goalNumber = Pattern.compile(",\\s*")
                 .splitAsStream(lastString)
                 .map(Integer::parseInt)
                 .collect(Collectors.toList());

         if (goalNumber.size() != 6)
             throw new IllegalArgumentException("입력된 지난주의 당첨 번호가 6개가 아닙니다.");

         return goalNumber;
    }

    public static int getLastweekBonusGoalNumber()
    {
        System.out.println("\n보너스 볼을 입력해 주세요.");
        int bonusNumber = Integer.parseInt(sc.nextLine());

        if (bonusNumber < 1 || bonusNumber > 45)
            throw new IllegalArgumentException("보너스 볼은 1~45 사이의 값이어야 합니다.");

        return bonusNumber;
    }
}
