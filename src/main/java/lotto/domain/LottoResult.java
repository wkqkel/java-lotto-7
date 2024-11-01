package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

class LottoResult {
    private final Map<LottoPrize, Integer> prizeCount;
    private final int totalCount;

    LottoResult(List<LottoPrize> prizes) {
        totalCount = prizes.size();
        prizeCount = new EnumMap<>(LottoPrize.class);
        for (LottoPrize prize : prizes) {
            prizeCount.put(prize, prizeCount.getOrDefault(prize, 0) + 1);
        }
    }

    public double getTotalRate() {
        long totalPrice = calculateTotalPrice();

        return round(totalPrice / (double) (totalCount * Lotto.PRICE) * 100);
    }

    private long calculateTotalPrice() {
        long total = 0;
        for (Map.Entry<LottoPrize, Integer> entry : prizeCount.entrySet()) {
            total += entry.getKey().getPrizeMoney() * entry.getValue();
        }

        return total;
    }

    private double round(double cal) {
        return (double) Math.round(cal * 10) / 10;
    }
}