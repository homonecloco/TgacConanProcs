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
package uk.ac.tgac.conan.process.asm;

import uk.ac.ebi.fgpt.conan.model.param.ProcessArgs;
import uk.ac.tgac.conan.core.data.Library;
import uk.ac.tgac.conan.core.data.Organism;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractAssemblerArgs implements ProcessArgs, AssemblerArgsCreator {

    public static final int DEFAULT_KMER = 65;

    private int kmer;
    private int coverageCutoff;
    private int memory;
    private int threads;
    private File outputDir;
    private List<Library> libraries;
    private Organism organism;
    private int desiredCoverage;



    protected AbstractAssemblerArgs() {
        this.kmer = DEFAULT_KMER;
        this.coverageCutoff = 0;
        this.memory = 0;
        this.threads = 0;
        this.outputDir = new File(".");
        this.libraries = new ArrayList<Library>();
        this.desiredCoverage = 75;
        this.organism = null;
    }

    public abstract AbstractAssemblerArgs copy();



    public int getKmer() {
        return kmer;
    }

    public void setKmer(int kmer) {
        this.kmer = kmer;
    }

    public int getCoverageCutoff() {
        return coverageCutoff;
    }

    public void setCoverageCutoff(int coverageCutoff) {
        this.coverageCutoff = coverageCutoff;
    }

    public int getThreads() {
        return threads;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }

    public File getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(File outputDir) {
        this.outputDir = outputDir;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }

    public int getDesiredCoverage() {
        return desiredCoverage;
    }

    public void setDesiredCoverage(int desiredCoverage) {
        this.desiredCoverage = desiredCoverage;
    }

    public Organism getOrganism() {
        return organism;
    }

    public void setOrganism(Organism organism) {
        this.organism = organism;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }
}
