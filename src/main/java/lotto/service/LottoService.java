package lotto.service;

import java.util.List;
import lotto.domain.Answer;
import lotto.domain.Lotto;
import lotto.domain.WinningResult;
import lotto.domain.LottoSeller;

public class LottoService {
    private final LottoSeller lottoSeller = new LottoSeller();
    private List<Lotto> lottos;
    private Answer answer = new Answer();

    public List<Lotto> buy(int price) {
        return lottos = lottoSeller.sell(price);
    }

    public void setWinningNumber(List<Integer> numbers) {
        answer.setNumbers(numbers);
    }

    public void setBonusNumber(int bonus) {
        answer.setBonusNumber(bonus);
    }

    public WinningResult getResult() {
        return answer.getResult(lottos);
    }
}