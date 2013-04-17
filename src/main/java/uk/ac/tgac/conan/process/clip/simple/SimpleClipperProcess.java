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
package uk.ac.tgac.conan.process.clip.simple;

import uk.ac.tgac.conan.process.clip.AbstractClipperProcess;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: maplesod
 * Date: 07/01/13
 * Time: 10:56
 * To change this template use File | Settings | File Templates.
 */
public class SimpleClipperProcess extends AbstractClipperProcess {

    public SimpleClipperProcess() {
        this(new SimpleClipperArgs());
    }

    public SimpleClipperProcess(SimpleClipperArgs args) {
        super(null, args, new SimpleClipperParams());
    }


    @Override
    public String getName() {
        return "RAMPART AbstractClipperProcess";
    }

    @Override
    public String getCommand() {
        return null;
    }


    private void clip() throws IOException {

        SimpleClipperArgs args = (SimpleClipperArgs)this.getProcessArgs();

        if (args.getInputFile() == null || !args.getInputFile().exists()) {
            throw new IOException("Input file does not exist");
        }

        BufferedReader reader = new BufferedReader(new FileReader(args.getInputFile()));
        PrintWriter writer = new PrintWriter(new FileWriter(args.getOutputFile()));

        // Ignore everything but the sequences
        // While loop handles multi-line sequences
        boolean firstLine = true;
        int nbSeqBases = 0;
        StringBuilder lastSeq = new StringBuilder();
        String lastHeader = "";
        String line = null;

        while ((line = reader.readLine()) != null) {

            if (!line.isEmpty()) {

                char firstChar = line.charAt(0);

                // If we have found a header line then increment analyser for this seq (unless this is the first time here)
                if (firstChar == '>') {

                    if (firstLine) {

                        // Store header
                        lastHeader = line;

                        firstLine = false;
                    } else {

                        // Print out the last sequence if it was big enough
                        if (nbSeqBases > args.getMinLen()) {
                            writer.println(lastHeader);
                            writer.println(lastSeq.toString());
                        }

                        // Store header and clean seq buffer
                        lastHeader = line;
                        lastSeq = new StringBuilder();
                        nbSeqBases = 0;
                    }
                } else {
                    lastSeq.append(line);
                    nbSeqBases += line.length();
                }
            }
        }

        writer.close();
        reader.close();
    }

}