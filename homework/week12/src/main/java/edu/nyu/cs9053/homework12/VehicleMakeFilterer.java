package edu.nyu.cs9053.homework12;

import edu.nyu.cs9053.homework12.model.Region;
import edu.nyu.cs9053.homework12.model.VehicleMake;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.function.Function;
/**
 * User: blangel
 * Date: 12/7/16
 * Time: 8:55 AM
 */
public class VehicleMakeFilterer {

    /**
     * @param region for which to query
     * @param nameStartsWith for which to check if the query results match
     * @param loader to load VehicleMake objects
     * @return loaded VehicleMake objects in {@code region} whose name starts with {@code nameStartsWith}
     */
    public static List<VehicleMake> loadMatching(Region region, String nameStartsWith, VehicleLoader loader) {
        if ((nameStartsWith == null) || (region == null) || (loader == null)) {
            throw new IllegalArgumentException("The VehicleLoader and both region and nameStartsWith are required when loading VehicleMake matches");
        }
        List<VehicleMake> regionMakes = loader.getVehicleMakesByRegion(region.name());
        if (regionMakes == null) {
            return null;
        }
        List<VehicleMake> matches = new ArrayList<>(regionMakes.size());
        for (VehicleMake make : regionMakes) {
            if ((make.getName() == null) || !make.getName().startsWith(nameStartsWith)) {
                continue;
            }
            matches.add(make);
        }
        return matches;
    }

    /**
     * Java 8 equivalent of {@link #loadMatching(Region, String, VehicleLoader)}
     * Note, this should use Java 8 streams API
     */
    public static Optional<List<VehicleMake>> loadMatchingJava8(Region region, String nameStartsWith, VehicleLoader loader) {
        Optional<Region> optionalRegion= Optional.ofNullable(region);
        Optional<String> optionalNameStartsWith= Optional.ofNullable(nameStartsWith);
        Optional<VehicleLoader> optionalLoader= Optional.ofNullable(loader);

        Function<Region, Optional<String>> regionGetName = s->Optional.of(s.name());
        Optional<String> name = optionalRegion.flatMap(regionGetName);

        Function<VehicleLoader,Optional<List<VehicleMake>>> getVehicleMakesByRegionWithOptional = s->Optional.of(s.getVehicleMakesByRegion(name.get()));
        Optional<List<VehicleMake>> regionMakes = optionalLoader.flatMap(getVehicleMakesByRegionWithOptional);
        
        List<VehicleMake> matches = regionMakes.get().stream().filter(c -> c.getName() != null).filter(c -> c.getName().startsWith(optionalNameStartsWith.get())).collect(Collectors.toList());
        Optional<List<VehicleMake>> optionalMatches= Optional.ofNullable(matches);
        return optionalMatches;

    }

}
