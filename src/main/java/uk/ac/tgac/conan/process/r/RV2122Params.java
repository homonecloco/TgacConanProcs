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
package uk.ac.tgac.conan.process.r;

import uk.ac.ebi.fgpt.conan.core.param.ArgValidator;
import uk.ac.ebi.fgpt.conan.core.param.ParameterBuilder;
import uk.ac.ebi.fgpt.conan.model.param.ConanParameter;
import uk.ac.ebi.fgpt.conan.model.param.ProcessParams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RV2122Params implements ProcessParams {

    private ConanParameter args;
    private ConanParameter script;
    private ConanParameter output;

    public RV2122Params() {

        this.args = new ParameterBuilder()
                .longName("args")
                .description("Any arguments that should be provided to the script")
                .isOption(false)
                .isOptional(false)
                .argIndex(1)
                .argValidator(ArgValidator.OFF)
                .create();

        this.script = new ParameterBuilder()
                .longName("script")
                .isOption(false)
                .isOptional(false)
                .argIndex(0)
                .argValidator(ArgValidator.PATH)
                .description("The R script to execute")
                .create();

        this.output = new ParameterBuilder()
                .longName("output")
                .description("The location to store output from R")
                .argIndex(2)
                .argValidator(ArgValidator.PATH)
                .isOption(false)
                .isOptional(false)
                .create();
    }

    public ConanParameter getArgs() {
        return args;
    }

    public ConanParameter getScript() {
        return script;
    }

    public ConanParameter getOutput() {
        return output;
    }

    @Override
    public List<ConanParameter> getConanParameters() {
        return new ArrayList<ConanParameter>(Arrays.asList(
                new ConanParameter[]{
                        this.args,
                        this.script,
                        this.output
                }
        ));
    }
}
