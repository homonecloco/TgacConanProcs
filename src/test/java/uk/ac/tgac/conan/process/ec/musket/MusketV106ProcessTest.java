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

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import uk.ac.ebi.fgpt.conan.service.exception.ConanParameterException;
import uk.ac.tgac.conan.core.data.Library;

import java.io.File;

import static org.junit.Assert.assertTrue;

/**
 * User: maplesod
 * Date: 03/05/13
 * Time: 10:55
 */
public class MusketV106ProcessTest {

    @Rule
    public TemporaryFolder temp = new TemporaryFolder();

    private String pwd;

    private String correctCommand;
    private String correctFullCommand;

    private File readsListFile = FileUtils.toFile(this.getClass().getResource("/ec/quake/readListFile.lst"));

    @Before
    public void setup() {

        String pwdFull = new File(".").getAbsolutePath();
        this.pwd = pwdFull.substring(0, pwdFull.length() - 2);

        correctCommand = "musket -k 15 53687091 -omulti output -p 32 -maxtrim 51 -inorder " + pwd + "/file1.fastq " + pwd + "/file2.fastq";
        correctFullCommand = "cd " + pwd + "/musket" + "; " + correctCommand + " 2>&1; cd " + pwd;
    }

    @Test
    public void testMusketCommand() throws ConanParameterException {

        MusketV106Process musket = new MusketV106Process(createMusketArgs());

        String command = musket.getCommand();

        assertTrue(command.equals(correctCommand));
    }

    @Test
    public void testMusketFullCommand() throws ConanParameterException {

        MusketV106Process musket = new MusketV106Process(createMusketArgs());
        musket.initialise();

        String command = musket.getFullCommand();

        assertTrue(command.equals(correctFullCommand));
    }


    protected MusketV106Args createMusketArgs() {


        Library lib = new Library();
        lib.setReadLength(101);
        lib.setFiles("file1.fastq", "file2.fastq");

        MusketV106Args args = new MusketV106Args();
        args.setOutputDir(new File("musket"));
        args.setMinLength(50);
        args.setQualityThreshold(50);
        args.setKmer(15);
        args.setThreads(32);
        args.setFromLibrary(lib);

        return args;
    }
}
