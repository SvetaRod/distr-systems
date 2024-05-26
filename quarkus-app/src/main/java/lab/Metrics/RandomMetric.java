package lab.Metrics;

import io.micrometer.core.instrument.MeterRegistry;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
public class RandomMetric {
    @Inject
    private MeterRegistry registry;
    private AtomicInteger atomicInteger;

    public RandomMetric(MeterRegistry registry) {
        atomicInteger = registry.gauge("random_metric", new AtomicInteger(0));
    }

    public void random() {
        int randomNum = new Random().nextInt(10);
        atomicInteger.set(randomNum);
    }
}
