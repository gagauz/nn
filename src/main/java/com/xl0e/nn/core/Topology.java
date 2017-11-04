package com.xl0e.nn.core;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Topology {

    private List<LayerTopology> layers;

    public int getNCount(int layerIndex) {
        return layers.get(layerIndex).nCount;
    }

    public ActivationFunction getActivationFunction(int layerIndex) {
        return layers.get(layerIndex).func;
    }

    private static class LayerTopology {
        int nCount;
        ActivationFunction func;

        public LayerTopology(int nCount) {
            this.nCount = nCount;
        }

        public LayerTopology(ActivationFunction func) {
            this.func = func;
        }
    }

    public static class Builder {

        private Topology topology;

        private Builder() {
            topology = new Topology();
        }

        public Builder layers(Integer... nCounts) {
            if (null == topology.layers) {
                topology.layers = Stream.of(nCounts).map(LayerTopology::new).collect(Collectors.toList());
            } else {
                check(nCounts);
                Iterator<LayerTopology> i = topology.layers.iterator();
                Stream.of(nCounts).forEach(n -> i.next().nCount = n);
            }
            return this;
        }

        public Builder funcs(ActivationFunction... funcs) {
            if (null == topology.layers) {
                topology.layers = Stream.of(funcs).map(LayerTopology::new).collect(Collectors.toList());
            } else {
                check(funcs);
                Iterator<LayerTopology> i = topology.layers.iterator();
                Stream.of(funcs).forEach(f -> i.next().func = f);
            }
            return this;
        }

        public Topology build() {
            return topology;
        }

        private <X> void check(X[] array) {
            if (topology.layers.size() != array.length) {
                throw new IllegalStateException("Counts of layers missmatch!");
            }
        }

        public Network buildNetwork() {
            Network n = new Network(topology);
            return n;
        }
    }

    public static Builder layers(Integer... nCounts) {
        Builder b = new Builder();
        b.layers(nCounts);
        return b;
    }

    public static Builder funcs(ActivationFunction... funcs) {
        Builder b = new Builder();
        b.funcs(funcs);
        return b;
    }

    public int getLayersCount() {
        return layers.size();
    }

}
