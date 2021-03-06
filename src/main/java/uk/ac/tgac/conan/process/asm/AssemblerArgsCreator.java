package uk.ac.tgac.conan.process.asm;

import uk.ac.tgac.conan.core.data.Library;
import uk.ac.tgac.conan.core.data.Organism;

import java.io.File;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: maplesod
 * Date: 10/12/13
 * Time: 12:28
 * To change this template use File | Settings | File Templates.
 */
public interface AssemblerArgsCreator {

    /**
     * Creates an instance of an AbstractAssembler using Basic args
     *
     * @return
     */
    AbstractAssemblerArgs create(int k,
                                     List<Library> libs,
                                     File outputDir,
                                     int threads,
                                     int memory,
                                     int coverage,
                                     Organism organism);

    /**
     * Gets the name of this process
     * @return
     */
    String getName();
}
