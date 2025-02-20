
データ型	bit数	値
boolean	1bit	true あるいは false
char	16bit	文字
byte	8bit	整数（扱える範囲は -128～127）
short	16bit	整数（扱える範囲は-32,768～32,767）
int	32bit	整数（扱える範囲は-2,147,483,648～2,147,483,647）
long	64bit	整数（扱える範囲は-9223372036854775808～9223372036854775807）
float	32bit	小数（精度低）
double	64bit	小数（精度高）

class Main {
    public static void main(String[] args) {
        int[] scores;
        scores = new int[3];

        scores[0] = 1;
        scores[1] = 5;
        scores[2] = 10;

        System.out.println(scores[0]);
        System.out.println(scores[1]);
        System.out.println(scores[2]);
    }
}