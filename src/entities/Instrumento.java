package entities;

public class Instrumento extends Produto{
    private String tipoDeInstrumento;

    public Instrumento(int id, String tipo, String marca, String modelo, double preco, String tipoDeInstrumento) {
        super(id, tipo, marca, modelo, preco);
        this.tipoDeInstrumento = tipoDeInstrumento;
    }

    public String getTipoDeInstrumento() {
        return tipoDeInstrumento;
    }
}
