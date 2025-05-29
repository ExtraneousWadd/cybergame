import java.util.Scanner;
import java.util.ArrayList;

public class ActionCard extends Card {
    private String effect;


    public ActionCard(String name, String effect) {
        super(name, "Action");
        this.effect = effect;
    }


    public String getEffect() {
        return effect;
    }


    @Override
    public String getDescription() {
        return name + " (Action: " + effect + ")";
    }

    public void useCard(){
        if(getName() == "Spoofing Attack"){
            spoofingAttack();
        }

    }

    public void spoofingAttack(ArrayList x){
        for(Player p : players){

        }
    }
}

