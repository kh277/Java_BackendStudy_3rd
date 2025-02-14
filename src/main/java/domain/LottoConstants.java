package domain;

public final class LottoConstants
{
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_COUNT = 6;
    public static final int BONUS_LOTTO_COUNT = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private LottoConstants()
    {
        throw new AssertionError("상속 에러");
    }
}
