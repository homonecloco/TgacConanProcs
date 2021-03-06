/**
 * RAMPART - Robust Automatic MultiPle AssembleR Toolkit
 * Copyright (C) 2013  Daniel Mapleson - TGAC
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **/
package uk.ac.tgac.conan.process.asm.stats;

import uk.ac.ebi.fgpt.conan.core.param.ArgValidator;
import uk.ac.ebi.fgpt.conan.core.param.ParameterBuilder;
import uk.ac.ebi.fgpt.conan.model.param.AbstractProcessParams;
import uk.ac.ebi.fgpt.conan.model.param.ConanParameter;

/**
 * User: maplesod
 * Date: 22/04/13
 * Time: 18:30
 */
public class CegmaV2_4Params extends AbstractProcessParams {

    private ConanParameter genomeFile;
    private ConanParameter outputPrefix;
    private ConanParameter threads;

    public CegmaV2_4Params() {

        this.genomeFile = new ParameterBuilder()
                .shortName("g")
                .longName("genome")
                .description("fasta file of the query sequence")
                .isOptional(false)
                .argValidator(ArgValidator.PATH)
                .create();

        this.outputPrefix = new ParameterBuilder()
                .shortName("o")
                .longName("output")
                .description("ouput file prefix")
                .isOptional(false)
                .argValidator(ArgValidator.PATH)
                .create();

        this.threads = new ParameterBuilder()
                .shortName("T")
                .longName("threads")
                .description("Specify number of processor threads to use")
                .isOptional(true)
                .argValidator(ArgValidator.DIGITS)
                .create();

    }

    public ConanParameter getGenomeFile() {
        return genomeFile;
    }

    public ConanParameter getOutputPrefix() {
        return outputPrefix;
    }

    public ConanParameter getThreads() {
        return threads;
    }

    @Override
    public ConanParameter[] getConanParametersAsArray() {
        return new ConanParameter[]{
                this.genomeFile,
                this.outputPrefix,
                this.threads
        };
    }
}
