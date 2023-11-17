package codingtest.sktelecom202206;

public class SkTel2 {
    int[] answer = new int[2];
    public int[] solution(int[] periods, int[][] payments, int[] estimates) {
        int n = periods.length;
        Info[] peopleArr = new Info[n];
        
        for(int i = 0; i<n; i++){
            int curPay = 0;
            int nextPay = 0;
            for(int j = 0; j<12; j++){
                curPay += payments[i][j];
            }
            nextPay = curPay - payments[i][0] + estimates[i];


            Info info = new Info(i,periods[i],periods[i]+1,curPay,nextPay);
            peopleArr[i] = info;
        }

        chkPeople(peopleArr,n);
        return answer;
    }

    public void chkPeople(Info[] peopleArr, int n){
        boolean curScore = false;   //현재 등급
        boolean nextScore = false;  //다음달 등급
        for(int i = 0; i<n; i++){
            curScore = false;
            nextScore = false;
            if(isVip(peopleArr[i].period, peopleArr[i].curPay)){ //이번달 vip인지 chk
                curScore = true;
            }
            if(isVip(peopleArr[i].nextPeriod, peopleArr[i].nextPay)){    //다음달 vip인지 chk
                nextScore = true;
            }

            getAnswer(curScore, nextScore);


        }
    }
    public boolean isVip(int period, int pay){
        boolean flag = false;
        if(24 <= period && period <60){
            if(pay >= 900000){
                flag = true;
            }
        }else if(period >= 60){
            if(pay >= 600000){
                flag = true;
            }
        }
        return flag;
    }




    public void getAnswer(boolean curScore, boolean nextScore){
        if(!curScore && nextScore){ //이번달 vip X , 다음달 vip
            answer[0] += 1;
        }else if(curScore && !nextScore){//이번달 vip O, 다음달 VIP X
            answer[1] += 1;
        }
    }
    public class Info{
        int no;     //사람 번호
        int period; //현재 가입 기간
        int nextPeriod; //다음달 가입 기간
        int curPay; //이번달까지 납부한 금액
        int nextPay; //다음달에 납부한 금액

        public Info(int no, int period, int nextPeriod, int curPay, int nextPay){
            this.no = no;
            this.period = period;
            this.nextPeriod = nextPeriod;
            this.curPay = curPay;
            this.nextPay = nextPay;
        }
    }
}