public class homework03 {
    public static void main(String[] args){
        int i,j,k;
        for(i=1;i<10;i++){
            for(j=1;j<10;j++){
                for(k=1;k<10;k++){
                    if(i*i*i+j*j*j+k*k*k==i*100+j*10+k){
                        System.out.println(i*100+j*10+k);
                    }
                }
            }
        }
    }
}
