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
package uk.ac.tgac.conan.process.ec.musket;

import org.kohsuke.MetaInfServices;
import uk.ac.tgac.conan.process.ec.AbstractErrorCorrector;
import uk.ac.tgac.conan.process.ec.AbstractErrorCorrectorArgs;

import java.io.File;

/**
 * User: maplesod
 * Date: 02/05/13
 * Time: 15:31
 */
@MetaInfServices(uk.ac.tgac.conan.process.ec.ErrorCorrectorCreator.class)
public class MusketV106Process extends AbstractErrorCorrector {

    protected static final String NAME = "Musket_V1.0.6";


    public MusketV106Process() {
        this(new MusketV106Args());
    }

    public MusketV106Process(AbstractErrorCorrectorArgs args) {
        super("musket", args, new MusketV106Params());
    }

    @Override
    public AbstractErrorCorrectorArgs getArgs() {
        return (AbstractErrorCorrectorArgs) this.getProcessArgs();
    }

    @Override
    public void initialise() {
        String pwdFull = new File(".").getAbsolutePath();
        String pwd = pwdFull.substring(0, pwdFull.length() - 2);

        this.addPreCommand("cd " + this.getArgs().getOutputDir().getAbsolutePath());
        this.addPostCommand("cd " + pwd);
    }


    @Override
    public AbstractErrorCorrector create(AbstractErrorCorrectorArgs args) {
        return new MusketV106Process(args);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
