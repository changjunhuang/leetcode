import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int index = 1;
        ArrayList<Integer> test1 = new ArrayList<>();
        test1.add(80);
        test1.add(30);
        test1.add(20);
        getResult(getPayAccount(100, test1), index++);
        getResult(getPayAccount(120, test1), index++);

        ArrayList<Integer> test2 = new ArrayList<>();
        test2.add(100);
        test2.add(20);
        test2.add(50);
        test2.add(30);
        getResult(getPayAccount(150, test2), index++);

        ArrayList<Integer> test3 = new ArrayList<>();
        test3.add(0);
        test3.add(100);
        test3.add(0);
        test3.add(10);
        getResult(getPayAccount(105, test3), index++);

        ArrayList<Integer> test4 = new ArrayList<>();
        test4.add(0);
        test4.add(1);
        test4.add(2);
        test4.add(10);
        test4.add(5);
        test4.add(5);
        getResult(getPayAccount(50, test4), index++);

        ArrayList<Integer> test5 = new ArrayList<>();
        test5.add(0);
        test5.add(0);
        test5.add(1000);
        test5.add(500);
        test5.add(200);
        test5.add(300);
        getResult(getPayAccount(2000, test5), index++);
    }

    /**
     * 获取所有可以支付的账号
     *
     * @param totalMoney
     * @param account
     * @return
     */
    public static List<Integer> getPayAccount(int totalMoney, ArrayList<Integer> account) {
        //  实际支付的账号，数组下标+1表示账号，数组值表示实际支付的钱
        List<Integer> payAccount = new ArrayList<>(account.size());
        int index = 0;

        //  当总付款金额大于0时不断循环
        while (totalMoney > 0) {
            //  如果index大于account时，表示支付账号遍历完成，金额不足以支付
            if (index >= account.size()) {
                return null;
            }
            //  当第index个账户的钱大于0时，进行总付款金额的加减
            if (account.get(index) > 0) {
                if (account.get(index) >= totalMoney) {
                    payAccount.add(totalMoney);
                    totalMoney = 0;
                }
                if (account.get(index) < totalMoney) {
                    payAccount.add(account.get(index));
                    totalMoney = totalMoney - account.get(index);
                }
            } else {
                payAccount.add(0);
            }
            index++;
        }

        //  如果总金额被减完，表示付款成功；否则表示所有账户都不足以支付
        if (totalMoney == 0) {
            return payAccount;
        }
        return null;
    }


    /**
     * 结果打印
     *
     * @param payAccount
     * @param index
     */
    public static void getResult(List<Integer> payAccount, int index) {
        System.out.println("第" + index + "个测试用例");
        if (payAccount == null) {
            System.out.println("当前账户不足以支付！");
            return;
        }
        for (int i = 0; i < payAccount.size(); i++) {
            if (payAccount.get(i) > 0) {
                System.out.println("账号" + (i + 1) + ":" + payAccount.get(i));
            }
        }
    }
}
