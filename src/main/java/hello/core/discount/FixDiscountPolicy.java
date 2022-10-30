package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000;
    private int discountJinho = 5000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else if (member.getGrade() == Grade.JINHO) {
            return discountJinho;
        } else {
            return 0;
        }
    }
}
