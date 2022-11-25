import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        client c1=new client();
        //System.out.println(c1.confirm_passwd());
        c1.recharge();
    }
}

class client{
    private String account,passwd;
    private double balance;
    public client(){
        this.balance=0;
        System.out.println("account init");
        if(create_account()==true)
            System.out.println("create account success");
        else
            System.out.println("create account fail");
    }
    public boolean create_account(){//创建账户
        String temp_acc,temp_passwd;
        boolean pass=false,success=false;
        Scanner input =new Scanner(System.in);
        System.out.println("input your email address");
        temp_acc=input.next();

        while(!pass){
            System.out.println("set your passwd(composed by 6~12 numbers)");
            temp_passwd=input.next();
            System.out.println("input again to confirm your passwd");
            if(input.next().equals(temp_passwd)==true){
                pass=true;
                success=true;
                this.account=temp_acc;
                this.passwd=temp_passwd;
            }
            else{
                System.out.println("Sorry,two inputs are not the same.Enter y or n to try again");
                if(input.next().equals("y")==true);
                else
                    pass=true;
            }
        }
        return success;
    }
    public boolean confirm_passwd(){
        boolean right=false,pass=false;
        int time=3;

        while(!pass&&(time>=0)){
            System.out.println("confirm your passwd");
            Scanner input=new Scanner(System.in);
            if(this.passwd.equals(input.next())==true) {
                right = true;
                pass=true;
            }
            else{
                time--;
                if(time<=0) {
                    System.out.println("You failed to enter the right passwd");
                    pass=true;
                }
                else
                    System.out.println("you have "+time+" times left");
            }
        }
        return right;
    }

    public boolean recharge(){
        double value=0;
        boolean success=false;
        Scanner input=new Scanner(System.in);
        if(confirm_passwd()==true) {
            System.out.println("Your account still has "+this.balance);
            System.out.println("Input the value you want to recharge");
            value = input.nextDouble();
            if (value <= 0)
                System.out.println("Wrong number");
            else {
                System.out.println("confirm the deal,enter y or n to continue");
                if (input.next().equals("y") == true) {
                    this.balance += value;
                    success = true;
                    System.out.println("recharge success,now this count has "+this.balance);
                }
            }
        }
        return success;
    }

    public void print_balance(){
        if(confirm_passwd()==true)
            System.out.println("Your account has"+this.balance);
    }
    public
}