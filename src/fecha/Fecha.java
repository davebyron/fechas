/*
 * Clase que comprueba si una fecha es correcta o no
 */
package fecha;

/**
 *
 * @author Tania Santirso
 */
public class Fecha {
    /**
     * dia del mes
     */
    private int dia;
    /**
     * mes
     */
    private int mes;
    /**
     * año
     */
    private int anno;

    /**
     * Constructor que inicializa los valores por defecto
     */
    public Fecha() {
    }
 
    /////////////////////GETS Y SETS////////////////////////////
    /**
     * @return the dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return the anno
     */
    public int getAnno() {
        return anno;
    }

    /**
     * @param anno the anno to set
     */
    public void setAnno(int anno) {
        this.anno = anno;
    }
    
    ////////////////////METODOS////////////////////
    /**
     * Metodo que comprueba si el año es bisiesto o no, para saber los dias que tiene el mes de febrero
     * @return devuelve si el mes de febrero tiene 28 o 29 dias
     */
    public int bisiesto(){
        int dias=28;
        if((anno%4==0 && anno%100!=0)|| anno%400==0){
            dias=29;
            
        }
        return dias;
    }
    /**
     *  Metodo que comprueba si el año es bisiesto o no, para saber los dias que tiene el mes de febrero
     * @param a usa el atributo año
     * @return devuelve si el mes de febrero tiene 28 o 29 dias
     */
    public int bisiesto(int a){
        int dias=28;
        if((anno%4==0 && anno%100!=0)|| anno%400==0){
            dias=29;
            
        }
        return dias;
    }
    
    /**
     * Metodo que comprueba si la fecha es correcta o no
     * @param d usa el atributo dia
     * @param m usa el atributo mes
     * @param a usa el atributo año
     * @return devuelve si la fecha es correcta o no(true o false)
     */
    public boolean comprobarFecha(int d, int m, int a){
        boolean resultado=true;
        int []diasMes={31,28,31,30,31,30,31,31,30,31,30,31};//declaramos un array. Lo ponemos asi pq sabemos todos los datos
        /*
        tambien se puede poner el array de esta forma:
        int[]diasMes=new int[12];
        diasMes[0]=31;
        diasMes[1]=28;
        diasMes[2]=31;
        .
        .
        .
        .
        diasMes[11]=31;
        */
                
        if(a<0)
        {//año menor que 0
            resultado=false;
        }//año menor que 0
        else
        {//año no menor que 0
            if(m<1 || m>12)
            {//mes menor q 1 o mayor q 12
                resultado=false;
            }//mes menor q 1 o mayor q 12
            else
            {//mes no menor q 1 o mayor q 12
                diasMes[1]=bisiesto(a);//la posicion 1 es febrero pq los arrays siempre empiezan por el 0
                if(d<1 || d>diasMes[m-1])//se pone m-1 pq los meses estan guardados como array y este empieza
                    //a guardar posiciones desde 0, por eso al mes q se introduzca hay q restarle una posicion
                {//dia menor q 1 o mayor q los dias guardados en ese mes
                    resultado=false;
                }//dia menor q 1 o mayor q los dias guardados en ese mes
            }//mes no menor q 1 o mayor q 12
        }//año no menor que 0
        return resultado;
    }
}
