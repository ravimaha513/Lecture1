import java.util.*;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.math.BigDecimal.ZERO;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;

class SamplePreprocessor {

    private final SampleNormalizer normalizer;

    SamplePreprocessor(SampleNormalizer normalizer) {
        this.normalizer = normalizer;
    }

    /*Stream<BigDecimal> preprocess(Stream<BigDecimal> input) {
        return input.filter(Objects::nonNull).filter(in -> in.compareTo(ZERO) > 0).map(Collectors.groupingBy(t -> ));
    }*/
}

class SampleNormalizer{
    Optional<Optional<BigDecimal>> normalize(BigDecimal bigDecimal){
        return Optional.of(Optional.ofNullable(bigDecimal));
    }
}