package io.github.raisenorth.autosale;

public class Sale implements Runnable {
    private int total = 50;
    private int number = total + 1;
    private boolean isselling = false;

    public void run() {
        while (true) {
            if (isselling == false) {
                isselling = true;
                if (this.total > 0) {
                    String msg = Thread.currentThread().getName() + " 售出第   " + (this.number - this.total) + "  张票";
                    System.out.println(msg);
                    this.total--;
                } else {
                    System.out.println("票已售完，请下次再来！");
                    System.exit(0);
                }
                isselling = false;

            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;

            }
            try {
                Thread.sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}