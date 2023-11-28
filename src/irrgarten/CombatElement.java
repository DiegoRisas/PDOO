package irrgarten;

public class CombatElement {
    private float effect; // Poder o protección
    private int uses;

    /**
     * Constructor con parámetros
     *
     * @param effect Valor del poder o protección
     * @param p_uses      Valor del número de usos
     */
    public CombatElement(float effect, int p_uses) {
        this.effect = effect;
        uses = p_uses;
    }

    /**
     * Método de instancia público sin parámetros llamado action que devuelve un
     * número en coma flotante representando la intensidad de la acción (ataque o
     * defensa) del jugador
     *
     * @return effect
     */
    protected float action() {
        if (uses > 0) {
            uses--;
            return effect;
        } else {
            return 0;
        }
    }

    /**
     * Método de instancia público que decide si el elemento debe ser descartado
     *
     * @return true or false
     */
    public boolean discard() {
        return Dice.discardElement(this.uses);
    }

    /**
     * Método toString
     *
     * @return String x
     */
    public String toString() {
        return "[" + getClass().getSimpleName() + effect + "," + uses + "]";
    }
}
