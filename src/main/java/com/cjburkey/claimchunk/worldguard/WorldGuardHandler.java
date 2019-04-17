package com.cjburkey.claimchunk.worldguard;

import org.bukkit.Chunk;

import static com.cjburkey.claimchunk.worldguard.WorldGuardApi.*;

/**
 * Created by CJ Burkey on 2019/04/16
 *
 * <p>
 * Safe wrapper for {@link com.cjburkey.claimchunk.worldguard.WorldGuardApi}
 * </p>
 */
public class WorldGuardHandler {

    private static boolean loaded = false;

    public static boolean init() {
        try {
            return (loaded = _init());
        } catch (NoClassDefFoundError ignored) {
        }
        return false;
    }

    public static boolean isAllowedClaim(Chunk chunk) {
        try {
            // If the WorldGuard api never loaded, just allow the claim
            return (!loaded || _isAllowedClaim(chunk));
        } catch (NoClassDefFoundError ignored) {
        }
        // This should never happen, but better safe than sorry
        return true;
    }

}
