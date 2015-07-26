package runner.scoreboard;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import mysql.MySQL;
import runner.Runner;
import runner.Runner.GameState;

public class LobbyScoreboard implements Listener{
	public static ArrayList<Player> players = new ArrayList<Player>();
@EventHandler
public void onMove(PlayerMoveEvent e){
	Scoreboard();
	players.add(e.getPlayer());
}

private void Scoreboard(){
	for(Player p : Bukkit.getOnlinePlayers()){
	if(!players.contains(p)){
		 new BukkitRunnable() {
	            @Override
	            public void run() {
	            	if(Runner.hasGameState(GameState.WAITING)){
	    			ScoreboardManager manager = Bukkit.getScoreboardManager();
	    			Scoreboard sc = manager.getNewScoreboard();
	    			Objective obj = sc.registerNewObjective("stats", "dummy");
	    			obj.setDisplayName("§a§lWaiting for Players");
	    			obj.setDisplaySlot(DisplaySlot.SIDEBAR);
	    			
	    			Score s1 = obj.getScore("§1");
	    			Score s2 = obj.getScore("§e§lPlayers");
	    			Score s3 = obj.getScore("" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers());
	    			Score s4 = obj.getScore("§2");
	    			Score s5 = obj.getScore("§7§lKit");
	    			Score s6 = obj.getScore("None");
	    			Score s7 = obj.getScore("");
	    			Score s8 = obj.getScore("§a§lGems");
	    			Score s9 = obj.getScore("" + MySQL.gems(p.getUniqueId().toString()));
	    			Score s10 = obj.getScore("§3");
	    			Score s11 = obj.getScore("§b§lServer");
	    			Score s12 = obj.getScore("OlympusDev-1");
	    			
	    			if(Runner.team.containsKey(p.getName()))
	    			{
	    				s5 = obj.getScore("§e§lKit");
	    			}
	    	        else if(!Runner.team.containsKey(p.getName())){
	    		        s5 = obj.getScore("§7§lKit");
	    		    }
	    			
	    	        if(Runner.jumper.contains(p.getName()))
	    			{
	    				s6 = obj.getScore("Jumper");
	    			}
	    	        else if(Runner.archer.contains(p.getName()))
	    			{
	    				s6 = obj.getScore("Archer");
	    			}
	    	        else if(Runner.frosty.contains(p.getName()))
	    			{
	    				s6 = obj.getScore("Frosty");
	    			}
	    			
	    			s1.setScore(12);
	    			s2.setScore(11);
	    			s3.setScore(10);
	    			s4.setScore(9);
	    			s5.setScore(8);
	    			s6.setScore(7);
	    			s7.setScore(6);
	    			s8.setScore(5);
	    			s9.setScore(4);
	    			s10.setScore(3);
	    			s11.setScore(2);
	    			s12.setScore(1);
	    			
	    			p.setScoreboard(sc);
	    			
	            	} if(Runner.hasGameState(GameState.STARTING)){
		    			ScoreboardManager manager = Bukkit.getScoreboardManager();
		    			Scoreboard sc = manager.getNewScoreboard();
		    			Objective obj = sc.registerNewObjective("stats", "dummy");
		    			obj.setDisplayName("§f§lStarting in §a§l" + Runner.seconds + " Seconds");
		    			obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		    			Score s1 = obj.getScore("§1");
		    			Score s2 = obj.getScore("§e§lPlayers");
		    			Score s3 = obj.getScore("" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers());
		    			Score s4 = obj.getScore("§2");
		    			Score s5 = obj.getScore("§7§lKit");
		    			Score s6 = obj.getScore("None");
		    			Score s7 = obj.getScore("");
		    			Score s8 = obj.getScore("§a§lGems");
		    			Score s9 = obj.getScore("" + MySQL.gems(p.getUniqueId().toString()));
		    			Score s10 = obj.getScore("§3");
		    			Score s11 = obj.getScore("§b§lServer");
		    			Score s12 = obj.getScore("OlympusDev-1");
		    			
		    			if(Runner.team.containsKey(p.getName()))
		    			{
		    				s5 = obj.getScore("§e§lKit");
		    			}
		    	        else if(!Runner.team.containsKey(p.getName())){
		    		        s5 = obj.getScore("§7§lKit");
		    		    }
		    			
		    	        if(Runner.jumper.contains(p.getName()))
		    			{
		    				s6 = obj.getScore("Jumper");
		    			}
		    	        else if(Runner.archer.contains(p.getName()))
		    			{
		    				s6 = obj.getScore("Archer");
		    			}
		    	        else if(Runner.frosty.contains(p.getName()))
		    			{
		    				s6 = obj.getScore("Frosty");
		    			}
		    			
		    			s1.setScore(12);
		    			s2.setScore(11);
		    			s3.setScore(10);
		    			s4.setScore(9);
		    			s5.setScore(8);
		    			s6.setScore(7);
		    			s7.setScore(6);
		    			s8.setScore(5);
		    			s9.setScore(4);
		    			s10.setScore(3);
		    			s11.setScore(2);
		    			s12.setScore(1);
		    			
		    			p.setScoreboard(sc);
	            	}
	            }
	        }.runTaskLater(Bukkit.getPluginManager().getPlugin("Game"), 20L);
	}
	}
	}
}
