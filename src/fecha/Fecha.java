/*
 * Clase que comprueba si una fecha es correcta o no
 */
package fecha;

/**
 *
 * @author David Marcos
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
     * Metodo que comprueba si el año es bisiesto o no, para saber los dias que
     * tiene el mes de febrero
     *
     * @return devuelve si el mes de febrero tiene 28 o 29 dias
     */
    public int bisiesto() {
        int dias = 28;
        if ((anno % 4 == 0 && anno % 100 != 0) || anno % 400 == 0) {
            dias = 29;

        }
        return dias;
    }

    /**
     * Metodo que comprueba si el año es bisiesto o no, para saber los dias que
     * tiene el mes de febrero
     *
     * @param a usa el atributo año
     * @return devuelve si el mes de febrero tiene 28 o 29 dias
     */
    public int bisiesto(int a) {
        int dias = 28;
        if ((a % 4 == 0 && a % 100 != 0) || a % 400 == 0) {
            dias = 29;

        }
        return dias;
    }

    /**
     * Metodo que comprueba si la fecha es correcta o no
     *
     * @param d usa el atributo dia
     * @param m usa el atributo mes
     * @param a usa el atributo año
     * @return devuelve si la fecha es correcta o no(true o false)
     */
    public boolean comprobarFecha(int d, int m, int a) {
        boolean resultado = true;
        int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};//declaramos un array. Lo ponemos asi pq sabemos todos los datos
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

        if (a < 0) {//año menor que 0
            resultado = false;
        }//año menor que 0
        else//año no menor que 0
         if (m < 1 || m > 12) {//mes menor q 1 o mayor q 12
                resultado = false;
            }//mes menor q 1 o mayor q 12
            else {//mes no menor q 1 o mayor q 12
                diasMes[1] = bisiesto(a);//la posicion 1 es febrero pq los arrays siempre empiezan por el 0
                if (d < 1 || d > diasMes[m - 1])//se pone m-1 pq los meses estan guardados como array y este empieza
                //a guardar posiciones desde 0, por eso al mes q se introduzca hay q restarle una posicion
                {//dia menor q 1 o mayor q los dias guardados en ese mes
                    resultado = false;
                }//dia menor q 1 o mayor q los dias guardados en ese mes
            }//mes no menor q 1 o mayor q 12//año no menor que 0
        return resultado;
    }

    public int calcularNumeroDeOrden() {
        int orden = 0;
        int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        diasMes[1] = bisiesto();
        for (int m = 0; m < mes - 1; m++) {
            orden = orden + diasMes[m];
            orden = orden + dia;
        }
        return dia;
    }

    /*
    METODO DESCONOCIDO
    public int diasFinAnno(){
    int dias;
    dias=diasAnno()-calcularNumeroOrden();
    return dias;
    }
     */
    /**
     * Método para comparar las fechas introducidas
     *
     * @param fecha
     * @return
     */
    public int compararFecha(Fecha fecha) {//inicio comparar fecha
        int resultado = 0;//iniciar el resultado a 0.
        if (anno < fecha.getAnno()) {
            resultado = 1;
        } else if (this.anno > fecha.getAnno()) {
            resultado = 2;
        } else if (mes < fecha.getMes()) {
            resultado = 1;
        } else if (mes > fecha.getMes()) {
            resultado = 2;
        } else if (dia < fecha.getDia()) {
            resultado = 1;
        } else if (dia > fecha.getDia()) {
            resultado = 2;
        }

        return resultado;

    }//fin comparar fecha

    /**
     * Método que sirve para ver la diferencia que hay de días entre las fechas
     * introducidas.
     *
     * @param fecha2
     * @return dias
     */
    public int diferenciaFecha(Fecha fecha2) {
        int dias;
        int m = mes;
        int a = anno + 1;
        dias = 0;
        if (anno == fecha2.getAnno()) {
            if (mes == fecha2.getMes()) {
                dias = fecha2.getDia() - dia;
            } else {
                int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //dias mes desde el array.   
                dias = diasMes[mes - 1] - dia;//contamos los días que tiene el mes, menos el día introducido. 
                while (m < fecha2.getMes() - 1) { //while: mientras que el mes sea menor que el mes introducido.
                    dias = dias + diasMes[m];//se suma los días que teníamos anteriormente a los dias del los meses que quedan-
                    m++;//se va sumando una con cada mes que hay entre las fechas.
                }//fin while m<fecha2.getMes()-1
            }
            dias = dias + fecha2.getDia();

        } 
        else {
            dias=diasQuedanAnno();
            while(a<fecha2.getAnno()){
            dias=annoBisiesto(a)+dias;
            a++;
            }
            dias=dias+diasPasanAnno();
        }
        return dias;
    }
/**
 * Método para comprobar si el año que metemos es bisiesto, como por 
 * ejemplo el 2016.
 * @param a
 * @return dias
 */
    public int annoBisiesto(int a) {
        int dias = 365;
        if ((a % 4 == 0 && a % 100 != 0) || a % 400 == 0) {
            dias = 366;
        }
        return dias;
    }

    public int annoBisiesto() {
        int dias = 365;
        if ((anno % 4 == 0 && anno % 100 != 0) || anno % 400 == 0) {
            dias = 366;
        }
        return dias;
    }
/**
 * Método para saber los días de quedan del año , a partir de la fecha.
 * @return 
 */
    public int diasPasanAnno() {//metodo diaspasanAno
        int diasHastaFecha = 0;//vble para acumular los dias que han pasado
        int mes;//vble para ir recorriendo los meses
        int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        diasMes[1] = bisiesto(anno);//compruebo si el año es bisiesto 
        for (mes = 1; mes < this.mes; mes++)//bucle que recorre el vector diasMes
        {//inicio for
            //acumulo los dias del mes hasta que llege al introducido
            diasHastaFecha = diasHastaFecha + diasMes[mes - 1];
        }//fin for
        diasHastaFecha = diasHastaFecha + dia;//acumulo los dias del mes no completo
        return diasHastaFecha;
    }//fin metodo diaspasanAnno

    
    /**
     * Método de los días que quedan del año, a partir de la fecha que
     * hemos introducido.
     * @return 
     */
    public int diasQuedanAnno() {
        int diasDesdeFecha = 0;
        int mes;
         int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        diasMes[1] = bisiesto(anno);
        diasDesdeFecha = diasMes[this.mes - 1] - dia;
        for (mes = this.mes + 1; mes <= 12; mes++) {
            diasDesdeFecha = diasDesdeFecha + diasMes[mes - 1];
        }
        return diasDesdeFecha;
    }

private void visualizaralgo(){
int percebes;
}
}//fin clase fecha




